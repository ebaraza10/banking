import { useEffect, useState } from 'react';
import Card from '../UI/Card';
import MealItem from './MealItem/MealItem';
import classes from './AvailableMeals.module.css';

const DUMMY_MEALS = [
  {
    id: 'm1',
    from_or_to: `From: Sushi`,
    channel: `Bank: 123456789`,
    amount: `KES 22.99`,
    date: `2022-07-29`,
  },
  {
    id: 'm2',
    from_or_to: 'Schnitzel',
    channel: 'A german specialty!',
    amount: 16.5,
    date: `2022-07-29`,
  },
  {
    id: 'm3',
    from_or_to: 'Barbecue Burger',
    channel: 'American, raw, meaty',
    amount: 12.99,
    date: `2022-07-29`,
  },
  {
    id: 'm4',
    from_or_to: 'Green Bowl',
    channel: 'Healthy...and green...',
    amount: 18.99,
    date: `2022-07-29`,
  },
];


const AvailableMeals = () => {
  const [transactions, setTransactions] = useState([]);

  useEffect(() => {
    const fetchTransactions = async () => {
      const response = await fetch('http://127.0.0.1:8080/api/transactions/transactions/?startDate=2022-07-27&endDate=2022-07-29&userId=62e179bbd3dcd9e9aab487cf');
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
  }, []);

  const mealsList = transactions.map((meal) => (
    <MealItem
      key={meal.id}
      id={meal.id}
      from_or_to={meal.from_or_to}
      channel={meal.channel}
      amount={meal.amount}
      date={meal.date}
      senderAccountNumber={meal.senderAccountNumber}
      recipientAccountNumber={meal.recipientAccountNumber}
    />
  ));

  return (
    <section className={classes.meals}>
      <Card>
        <ul>{mealsList}</ul>
      </Card>
    </section>
  );
};

export default AvailableMeals;
