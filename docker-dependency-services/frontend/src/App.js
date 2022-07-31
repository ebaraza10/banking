import { Fragment } from 'react';
import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';
import { useState } from 'react';

import Header from './components/Layout/Header';
import Dashboard from './components/Dashboard/Dashboard';
import Transactions from './components/Transactions/Transactions';

function App() {

  return (
    <Fragment>
        <Header />
          <main>
          <BrowserRouter>
          <Routes>
          <Route
          path="/"
          element={<Navigate to="/dashboard" replace />}
          />
          <Route path="/dashboard" element={<Dashboard />} />
          
          <Route path="/transactions" element={<Transactions />} />
          </Routes>

          
          </BrowserRouter>
          </main>
    </Fragment>
  );
}

export default App;
