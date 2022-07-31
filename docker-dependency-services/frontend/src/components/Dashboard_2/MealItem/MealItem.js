import { useContext } from 'react';

import MealItemForm from './MealItemForm';
import classes from './MealItem.module.css';
import CartContext from '../../../store/cart-context';

const MealItem = (props) => {
  const cartCtx = useContext(CartContext);

  const amount = props.amount; //`$${props.price.toFixed(2)}`;

  const addToCartHandler = amount => {
    cartCtx.addItem({
      id: props.id,
      from_or_to: props.from_or_to,
      channel: props.channel,
      amount: props.amount,
      date: props.date
    });
  };

  return (
    <li className={classes.meal}>
      <div className={classes.date}>
        <h3>{props.from_or_to}</h3>
        <div className={classes.channel}>{props.channel}</div>
        <div className={classes.amount}>{amount}</div>
        <div>
        <MealItemForm date={props.date} onAddToCart={addToCartHandler} />
      </div>
      </div>
     
    </li>
  );
};

export default MealItem;
