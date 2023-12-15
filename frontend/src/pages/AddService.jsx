// ServiceForm.js
import { useState } from "react";

export default function AddService() {
  const [serviceType, setServiceType] = useState("");
  const [description, setDescription] = useState("");
  const [photos, setPhotos] = useState([]);
  const [price, setPrice] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    // Aquí puedes enviar los datos al proveedor de servicios o realizar cualquier otra acción
    const formData = {
      serviceType,
      description,
      photos,
      price,
    };

    console.log(formData);
    // Puedes hacer una solicitud HTTP para enviar los datos al backend aquí
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
            <option value="Limpieza del hogar">Limpieza del hogar</option>
            <option value="Mantenimiento del jardín">
              Mantenimiento del jardín
            </option>
            <option value="Organización del hogar">
              Organización del hogar
            </option>
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
          Agregar Servicio
        </button>
      </form>
    </section>
  );
}
