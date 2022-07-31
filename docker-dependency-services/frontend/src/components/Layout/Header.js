import { useEffect, useState } from 'react';
import { Fragment } from 'react';
import HeaderCartButton from './HeaderCartButton';

import mealsImage from '../../assets/transactions.png';
import classes from './Header.module.css';
import Configs from '../../shared/configs';

const Header = (props) => {
  const [name, setName] = useState([]);

  useEffect(() => {
    const fetchName = async () => {
      const response = await fetch(`${Configs.apiUrl}/api/users/users/?id=62e578d046b2d9bc4ec8619b`);
      const responseData = await response.json();

      setName(responseData[0].firstName);
    };

    fetchName();
  }, []);

  return (
    <Fragment>
      <header className={classes.header}>
      <h2>
      <img src="https://static.vecteezy.com/system/resources/thumbnails/000/439/863/small/Basic_Ui__28186_29.jpg" alt='Loans icon' className={classes['profile-image']}/>
        Hello {name}</h2>
        <HeaderCartButton onClick={props.onShowCart} />
      </header>
      <div className={classes['main-image']}>
        <img src={mealsImage} alt='A table full of delicious food!' className={classes.img_}/>
      </div>
    </Fragment>
  );
};

export default Header;
