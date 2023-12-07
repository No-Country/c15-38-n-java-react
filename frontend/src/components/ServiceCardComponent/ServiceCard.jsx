import PropTypes from "prop-types";

const ServiceCard = ({ title, image, additionalContent }) => (
  <div>
    <img
      className="object-center w-full mb-4 transition duration-300 ease-in-out shadow-md lg:h-48 md:h-36 rounded-xl hover:scale-110"
      src={image}
      alt={title}
    />

    <div className="flex justify-between">
      <p className="text-lg font-semibold font-SourceSansPro dark:text-portfolio-background-color">
        {title}
      </p>
    </div>

    {additionalContent && <div>{additionalContent}</div>}
  </div>
);

ServiceCard.propTypes = {
  title: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
  additionalContent: PropTypes.node,
};

export default ServiceCard;
