import { useRef, useState } from 'react';

import Input from '../../UI/Input';
import classes from './DateItem.module.css';

const DateItem = (props) => {
  return (
      <label className={classes.form}><b>{props.date}</b></label>
  );
};

export default DateItem;
