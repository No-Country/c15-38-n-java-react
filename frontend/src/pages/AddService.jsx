import { useState, useEffect } from "react";
import { agregarServicio } from "../../api/api";

export default function AddService() {
  const [serviceType, setServiceType] = useState("");
  const [description, setDescription] = useState("");
  const [photos, setPhotos] = useState([]);
  const [price, setPrice] = useState("");
  const [services, setServices] = useState([]);
  const [isFormSubmitted, setIsFormSubmitted] = useState(false);

  useEffect(() => {
    // Fetch services from the backend API
    const fetchServices = async () => {
      try {
        const response = await fetch(
          "https://servilink-api.onrender.com/api/service/get-all-services"
        );
        const data = await response.json();
        setServices(data);
      } catch (error) {
        console.error("Error fetching services:", error);
      }
    };

    // Call the fetch function
    fetchServices();
  }, []); // Empty dependency array

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Form validation
    if (!serviceType || !photos.length || !price) {
      alert("Por favor, complete todos los campos obligatorios.");
      return;
    }

    const selectedService = services.find(
      (service) => service.service === serviceType
    );

    const formData = {
      idProvider: 0,
      idService: selectedService.id,
      description,
      price: parseFloat(price),
    };

    try {
      const result = await agregarServicio(formData);

      console.log("Service added successfully!", result);

      setServiceType("");
      setDescription("");
      setPhotos([]);
      setPrice("");
      setIsFormSubmitted(true);

      setTimeout(() => {
        setIsFormSubmitted(false);
      }, 3000);
    } catch (error) {
      console.error("Error adding service in ServiceForm:", error);
      alert(
        "Hubo un error al agregar el servicio. Por favor, inténtelo de nuevo."
      );
    }
  };

  return (
    <section className="mt-[150px] lg:max-w-[59rem] px-4 md:px-10 lg:px-0 xl:max-w-[80rem] 2xl:max-w-[90rem] mx-auto mb-16">
      <div>
        <h1 className="text-lg font-medium">Agregar Servicio</h1>
      </div>

      <form
        className="flex flex-col gap-6 mt-8"
        onSubmit={handleSubmit}
      >
        <div className="flex flex-col gap-4">
          <label
            className="text-sm font-medium"
            htmlFor="serviceType"
          >
            Tipo de Servicio:
          </label>
          <select
            id="serviceType"
            value={serviceType}
            onChange={(e) => setServiceType(e.target.value)}
            className="w-full border rounded py-[14px]"
          >
            <option value="">Selecciona un servicio</option>
            {services.map((service, index) => (
              <option
                key={index}
                value={service.service}
              >
                {service.service}
              </option>
            ))}
          </select>
        </div>

        <div className="flex flex-col gap-4">
          <label
            className="text-sm font-medium"
            htmlFor="photos"
          >
            Fotos del Servicio:
          </label>
          <input
            type="file"
            id="photos"
            onChange={(e) => setPhotos(e.target.files)}
            multiple
          />
        </div>

        <div className="flex flex-col gap-4">
          <label
            className="text-sm font-medium"
            htmlFor="price"
          >
            Precio del Servicio:
          </label>
          <input
            type="number"
            id="price"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
            className="w-full border rounded py-[14px]"
          />
        </div>

        <div className="flex flex-col gap-4">
          <label
            className="text-sm font-medium"
            htmlFor="description"
          >
            Descripción del Servicio:
          </label>
          <textarea
            id="description"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            className="w-full border rounded py-[14px]"
          />
        </div>

        <button
          className="w-full border rounded p-[14px] bg-black text-white md:w-1/2 xl:w-1/3"
          type="submit"
        >
          {isFormSubmitted ? "Servicio Agregado" : "Agregar Servicio"}
        </button>
      </form>
    </section>
  );
}
