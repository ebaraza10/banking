import { useEffect, useState } from 'react';
import classes from './MealsSummary.module.css';
import loansImage from '../../assets/loans.png';
import Card from '../UI/CardMin';

const MealsSummary = () => {
  const [loans, setLoans] = useState([]);
  const [paymentsSent, setPaymentsSent] = useState([]);
  const [paymentsRecieved, setPaymentsRecieved] = useState([]);
  const [total, setTotal] = useState([]);

  useEffect(() => {
    const fetchName = async () => {
      const response = await fetch('http://127.0.0.1:8080/api/dashboard/?userId=62e179bbd3dcd9e9aab487cf');
      const responseData = await response.json();

      setLoans(`KES ${responseData.loans}`);
      setPaymentsSent(`KES ${responseData.paymentsSent}`);
      setPaymentsRecieved(`KES ${responseData.paymentsRecieved}`);
      setTotal(`KES ${responseData.total}`);
    };

    fetchName();
  }, []);

  return (
    <section className={classes.summary}>
      <div className={classes['align-left1']}>
        <div>
        <img src={loansImage} alt='Loans icon' className={classes['loans-image']}/>
        </div>
      <div className={classes.card_item}>
      <Card>
        <h4>Loan balance</h4>
        <p>
          <h5>{loans}</h5>
        </p>
      </Card>
      </div>
      </div>

      <div className={classes['align-left']}>
      <div>
      <img src={loansImage} alt='Loans icon' className={classes['loans-image']}/>
      </div>
      <div className={classes.card_item}>
      <Card>
        <h4>Payments made</h4>
        <p>
          <h5>{paymentsSent}</h5>
        </p>
      </Card>
      </div>
      </div>


      <div className={classes['align-left']}>
      <div>
      <img src={loansImage} alt='Loans icon' className={classes['loans-image']}/>
      </div>
      <div className={classes.card_item}>
      <Card>
        <h4>Payments recieved</h4>
        <p>
          <h5>{paymentsRecieved}</h5>
        </p>
      </Card>
      </div>
      </div>


      <div className={classes['align-left']}>
      <div>
      <img src={loansImage} alt='Loans icon' className={classes['loans-image']}/>
      </div>
      <div className={classes.card_item}>
      <Card>
        <h4>Total transacted</h4>
        <p>
          <h5>{total}</h5>
        </p>
      </Card>
      </div>
      </div>


      
    </section>
  );
};


export default MealsSummary;
