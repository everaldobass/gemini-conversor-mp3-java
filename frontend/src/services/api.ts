import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080/api', // Endereço do seu Backend Spring Boot
});

// Adiciona o token de login em todas as chamadas automaticamente
api.interceptors.request.use((config) => {
  const token = typeof window !== 'undefined' ? localStorage.getItem('@WAVR:token') : null;
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;