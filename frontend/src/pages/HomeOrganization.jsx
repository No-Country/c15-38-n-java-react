import ServiceCard from "../components/ServiceCardComponent/ServiceCard";
import axios from "axios";
import React, {useEffect, useState} from "react";

const HomeOrganizationData = [
  {
    title: "Ejemplo",
    description: "Corte en figuras",
    image: "./images/download 4.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/2.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/3.jpg",
  },
  {
    title: "Ejemplo",
    image: "./images/4.jpg",
  },
];

const ejemplo = {
  "content": [
      {
          "id": 1,
          "providerDataGetOne": {
              "firstName": "Juan",
              "lastName": null,
              "email": "juan@mail.com",
              "phoneNumber": null,
              "profileImageUrl": null
          },
          "service": {
              "id": 1,
              "name": "Limpieza del hogar"
          },
          "description": "Mi servicio de limpieza de hogares full HD",
          "price": 8000
      }
  ],
  "pageable": {
      "pageNumber": 0,
      "pageSize": 10,
      "sort": {
          "empty": true,
          "unsorted": true,
          "sorted": false
      },
      "offset": 0,
      "paged": true,
      "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "size": 10,
  "number": 0,
  "sort": {
      "empty": true,
      "unsorted": true,
      "sorted": false
  },
  "numberOfElements": 1,
  "first": true,
  "empty": false
};

export default function HomeOrganization() {

  const url="https://servilink-api.onrender.com/api/service-provider/get-all-by-service/1"
  const [allservices1, setAllServices1]=useState({});
  const [contents, setContents]=useState([]);
  
  useEffect( ()=>{
    getAllServices1();
  },[]);

  const getAllServices1 = async ()=>{
    const respuesta = await axios.get(url);
    setAllServices1(respuesta.data);
  }

  console.log(allservices1);

  return (
    <section className="mt-[150px] lg:max-w-[59rem] px-4 md:px-10 lg:px-0 xl:max-w-[80rem] 2xl:max-w-[90rem] mx-auto mb-16">
      <h1 className="text-xl font-semibold">Organización del hogar</h1>
        
      <div>
        {allservices1.content.map((servicio,i)=>(
          <div key={servicio.id}><p>Descripción: {servicio.description}</p><p>Precio: {servicio.price}</p></div>
        ))
        }
      </div>

      <div className="mt-4">
        <div className="relative items-center w-full mt-8">
          <div className="grid w-full gap-12 lg:grid-cols-3 md:grid-cols-2 xl:grid-cols-4 2xl:grid-cols-6">
            {HomeOrganizationData.map((project, index) => (
              <ServiceCard
                key={index}
                title={project.title}
                image={project.image}
                additionalContent={<p>Additional content for Home Cleaning</p>}
              />
            ))}
          </div>
        </div>
      </div>
    </section>
  );
}
