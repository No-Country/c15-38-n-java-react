import PropTypes from "prop-types";

const ServiceCard = ({ title, image, additionalContent }) => (
  <div className="w-full">
    <img
      className="object-cover w-full rounded-lg h-60"
      src={image}
      alt={title}
    />

    <div className="flex justify-between">
      <p className="font-medium font-SourceSansPro dark:text-portfolio-background-color">
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
