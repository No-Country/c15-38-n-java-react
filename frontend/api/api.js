// api/api.js
import axios from 'axios';

const apiUrl = 'https://servilink-api.onrender.com'; 

export const registrarUsuario = async (userData) => {
  const response = await axios.post(`${apiUrl}/api/auth/signup`, userData);
  return response.data; 
};

export const agregarServicio = async (servicioData) => {
  try {
    const response = await axios.post(`${apiUrl}/your-service-endpoint`, servicioData);
    return response.data;
  } catch (error) {
    // Handle errors here, such as logging or displaying an error message
    console.error("Error adding service:", error);
    throw error; // Re-throw the error for the component to handle if needed
  }
};
