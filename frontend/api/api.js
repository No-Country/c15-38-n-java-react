// api/api.js
import axios from 'axios';

const apiUrl = 'https://servilink-api.onrender.com'; 

export const registrarUsuario = async (userData) => {
  const response = await axios.post(`${apiUrl}/api/auth/signup`, userData);
  return response.data; 
};
