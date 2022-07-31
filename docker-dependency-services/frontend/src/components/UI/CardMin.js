import classes from './Card.module.css';

const Card = props => {
  return <div className={classes.card_min}>{props.children}</div>
};

export default Card;