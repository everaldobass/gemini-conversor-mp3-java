import React, { useState } from 'react';
import './App.css'; // Importamos nosso CSS customizado

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = (e) => {
    e.preventDefault();
    console.log("Dados:", { email, password });
  };

  return (
    <div className="container d-flex align-items-center justify-content-center vh-100">
      <div className="row w-100 justify-content-center">
        <div className="col-12 col-md-5">
          
          <div className="login-card text-center">
            <h2 className="mb-4 fw-bold" style={{ color: '#4f46e5' }}>Login</h2>
            
            <form onSubmit={handleLogin}>
              {/* Campo Email */}
              <div className="mb-3 text-start">
                <label className="form-label small text-secondary ms-2">Username / Email</label>
                <input 
                  type="email" 
                  className="form-control custom-input" 
                  placeholder="Seu email..."
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
              </div>

              {/* Campo Senha */}
              <div className="mb-4 text-start">
                <label className="form-label small text-secondary ms-2">Password</label>
                <input 
                  type="password" 
                  className="form-control custom-input" 
                  placeholder="Sua senha..."
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
              </div>

              {/* Botão Entrar */}
              <button type="submit" className="btn btn-gradient w-100 mb-3">
                LOGIN
              </button>
            </form>

            <p className="small text-secondary">
              Não tem uma conta? <a href="#" style={{ color: '#7c3aed', textDecoration: 'none' }}>Cadastre-se</a>
            </p>
          </div>

        </div>
      </div>
    </div>
  );
};

export default Login;