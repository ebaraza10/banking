import { Fragment } from 'react';

import DashboardSummary from './DashboardSummary';
import TransactionsList from '../Transactions/TransactionsList';

const Meals = () => {
  return (
    <Fragment>
      <DashboardSummary />
      <TransactionsList />
    </Fragment>
  );
};

export default Meals;
