import { useContext } from 'react';

import DateItem from './DateItem';
import classes from './TransactionItem.module.css';

const TransactionItem = (props) => {

  const amount = props.amount;

  return (
    <li className={classes.meal}>
      <div className={classes.date}>
        <h3>{props.from_or_to}</h3>
        <div className={classes.channel}>{props.channel}</div>
        <div className={classes.amount}>{amount}</div>
        <div>
        <DateItem date={props.date} />
      </div>
      </div>
     
    </li>
  );
};

export default TransactionItem;
