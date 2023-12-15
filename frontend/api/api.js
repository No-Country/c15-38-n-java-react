// api/api.js
import axios from 'axios';

const apiUrl = 'https://servilink-api.onrender.com'; // Reemplaza con la URL real de la API

export const registrarUsuario = async (userData) => {
  const response = await axios.post(`${apiUrl}/api/auth/signup`, userData);
  return response.data; // Puedes devolver datos adicionales según sea necesario
};

// Puedes agregar más funciones para otras llamadas a la API según sea necesario
