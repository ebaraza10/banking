import { useState } from 'react';
import { Fragment } from 'react';

import MealsSummary from './TransactionSummary';
import TransactionsList from './TransactionsList';

const Transactions = () => {
  const [dates, setDates] = useState({});
  return (
      <Fragment>
        <MealsSummary setDates={setDates}/>
        <TransactionsList dates={dates}/>
    </Fragment>
  );
};

export default Transactions;
