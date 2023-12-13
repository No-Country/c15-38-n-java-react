import PropTypes from "prop-types";

const ProviderDataCard = ({ name, contact, email, image }) => (
  <div className="w-80 flex flex-col items-center">

    <div className="">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        {name}
      </p>
    </div>

    <img
      className="rounded-lg object-cover w-60 h-60 mx-[10px] my-[5px]"
      src={image}
      alt={name}
    />

    <div className="">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        Teléfono: {contact}
      </p>
    </div>

    <div className="">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color mx-[10px] my-[5px]">
        Correo: {email}
      </p>
    </div>

  </div>
);

ProviderDataCard.propTypes = {
  name: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
};

export default ProviderDataCard;