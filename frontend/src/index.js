import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Join from './pages/Join';
import Landing from './pages/Landing';
import Login from './pages/Login';
import Main from './pages/Main';
import PasswordChange from './pages/PasswordChange';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path='/login' element={<Login />} />
      <Route path='/landing' element={<Landing />} />
      <Route path='/join' element={<Join />} />
      <Route path='/password-change' element={<PasswordChange />} />
      <Route path='/' element={<Main />} />
    </Routes>
  </BrowserRouter>
);
