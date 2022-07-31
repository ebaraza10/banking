import classes from './TransactionSummary.module.css';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import React, { useState } from "react";

const TransactionSummary = (props) => {
  const [startDate, setStartDate] = useState(new Date());
  const [endDate, setEndDate] = useState(new Date());

  const handleInputChange = (date, type) => {

    type == 'startDate'?  setStartDate(date): setEndDate(date);
    if(type == 'startDate' && (date > endDate)){
      alert(`The start date must come before the end date.`);
    }
    else if(type == 'endDate' && (startDate > date)){
      alert(`The start date must come before the end date.`);
    }
    else{
      props.setDates(
        {startDate: type == 'startDate'? date: startDate,
        endDate: type == 'endDate'? date: endDate}
      );
    }
  };

  return (
    <div className={classes.summary}>

      
    <div className={classes.div_wrapper}>
      <span className={classes.align_left}>
        <label>From:</label>
      <DatePicker selected={startDate} onChange={(date) => handleInputChange(date, 'startDate')} className={classes.date_picker_height}/>
      </span>
      
      <span className={classes.align_right}>
      <label>To:</label>
      <DatePicker selected={endDate} onChange={(date) => handleInputChange(date, 'endDate')} className={classes.date_picker_height}/>
      </span>
    </div>
      
    </div>
  );
};


export default TransactionSummary;
