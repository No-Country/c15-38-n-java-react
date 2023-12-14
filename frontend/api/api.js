// api/api.js
import axios from 'axios';

const apiUrl = 'https://api.servilink.com'; // Reemplaza con la URL real de la API

export const obtenerDatos = () => {
  return axios.get(`${apiUrl}/ruta-del-endpoint`)
    .then(response => response.data)
    .catch(error => {
      throw error;
    });
};

// Puedes agregar más funciones para otras llamadas a la API según sea necesario
