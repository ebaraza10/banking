import { BrowserRouter, Route, Switch, Redirect, NavLink } from 'react-router-dom';

import classes from './HeaderCartButton.module.css';

const HeaderCartButton = (props) => {

  return (
    <div>
  
      <span>
      <BrowserRouter>
        <a href='/dashboard' className={classes.link_}>See dashboard</a>
      </BrowserRouter>

      <BrowserRouter>
        <a href='/transactions' className={classes.link_}>See all transactions</a>
      </BrowserRouter>
        </span>
    </div>
  );
};

export default HeaderCartButton;
