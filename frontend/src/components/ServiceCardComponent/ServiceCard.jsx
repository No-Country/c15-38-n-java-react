import PropTypes from "prop-types";
import { Link } from "react-router-dom";

const ServiceCard = ({ id, title, image, additionalContent }) => (
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

    <Link className="" to="/service">
      <button className="bg-black border rounded w-[80px] h-[30px] text-xs text-white">Ver más</button>
    </Link>

  </div>
);

ServiceCard.propTypes = {
  title: PropTypes.string.isRequired,
  image: PropTypes.string.isRequired,
  additionalContent: PropTypes.node,
};

export default ServiceCard;
