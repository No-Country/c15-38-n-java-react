import PropTypes from "prop-types";

const ProviderDataCard = ({ name, contact, email, image }) => (
  <div className="w-full flex flex-wrap items-center p-[10px]">

    <img
      className="rounded-lg object-cover w-48 h-48 mx-[10px] my-[10px]"
      src={image}
      alt={name}
    />

    <div className="flex flex-col h-full">

      <p className="text-2xl font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        {name}
      </p>

      <div className="">
        <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
          Teléfono: {contact}
        </p>
        <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
          Correo: {email}
        </p>
      </div>
      
    </div>

  </div>
);

ProviderDataCard.propTypes = {
  name: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
};

export default ProviderDataCard;