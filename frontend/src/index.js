import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Signup from './pages/Signup';
import Landing from './pages/Landing';
import Login from './pages/Login';
import Main from './pages/Main';
import PasswordChange from './pages/PasswordChange';
import SubjectCheck from './pages/SubjectCheck';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path='/login' element={<Login />} />
      <Route path='/signup' element={<Signup />} />
      <Route path='/password-change' element={<PasswordChange />} />
      <Route path='/subject-check' element={<SubjectCheck />} />
      <Route path='/main' element={<Main />} />
      <Route path='/' element={<Landing />} />
    </Routes>
  </BrowserRouter>
);
