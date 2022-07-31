import { useEffect, useState } from 'react';
import Card from '../UI/Card';
import TransactionItem from './TransactionItem/TransactionItem';
import classes from './TransactionsList.module.css';
import Configs from '../../shared/configs';


const TransactionsList = (props) => {
  const [transactions, setTransactions] = useState([]);

  let startDate = props.dates?.startDate;
  let endDate = props.dates?.endDate;
  if(endDate == undefined){
    startDate = '2022-07-27';
  }
  else{
    startDate = props.dates.startDate.toLocaleDateString('en-CA')
  }
  if(endDate == undefined){
    endDate = '2022-07-30';
  }
  else{
    endDate = props.dates.endDate.toLocaleDateString('en-CA')
  }
  

  useEffect(() => {
    const fetchTransactions = async () => {
      const response = await fetch(`${Configs.apiUrl}/api/transactions/transactions/?startDate=${startDate}&endDate=${endDate}&userId=62e179bbd3dcd9e9aab487cf`);
      const responseData = await response.json();


      const loadedTransactions = [];

      for (const key in responseData) {
        const sender = `${responseData[key].sender.firstName} ${responseData[key].sender.lastName}`;
        const reciever = `${responseData[key].receipient.firstName} ${responseData[key].receipient.lastName}`;
        
        const senderAccount = `${responseData[key].senderAccountNumber}`;
        const recieverAccount = `${responseData[key].recipientAccountNumber}`;
        const account = responseData[key].direction == 'SENDING'? senderAccount: recieverAccount;
        const amount = responseData[key].direction == 'SENDING'? `-KES ${responseData[key].amount}`: `+KES ${responseData[key].amount}`;
        
        loadedTransactions.push({
          id: key,
          from_or_to: responseData[key].direction == 'SENDING'? `FROM: ${sender}`: `TO: ${reciever}`,
          channel: `${responseData[key].channel}: ${account}`,
          amount: amount,
          date: responseData[key].date,
          senderAccountNumber: responseData[key].senderAccountNumber,
          recipientAccountNumber: responseData[key].recipientAccountNumber,
        });
      }

      setTransactions(loadedTransactions);
    };

    fetchTransactions();
  }, [startDate, endDate]);

  const mealsList = transactions.map((transaction) => (
    <TransactionItem
      key={transaction.id}
      id={transaction.id}
      from_or_to={transaction.from_or_to}
      channel={transaction.channel}
      amount={transaction.amount}
      date={transaction.date}
      senderAccountNumber={transaction.senderAccountNumber}
      recipientAccountNumber={transaction.recipientAccountNumber}
    />
  ));

  return (
    <section className={classes.meals}>
      { mealsList.length > 0 && <Card>
        <ul>{mealsList}</ul>
      </Card>
      }
      { mealsList.length == 0 && <div className={classes.card}>No transactions found for the specified period</div>
      }
    </section>
  );
};

export default TransactionsList;
