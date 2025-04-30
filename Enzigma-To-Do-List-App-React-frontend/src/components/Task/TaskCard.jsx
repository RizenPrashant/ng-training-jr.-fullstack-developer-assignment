import React from 'react';
import PropTypes from 'prop-types';
import './TaskCard.css'; // Optional: Add CSS for styling

const TaskCard = ({ task }) => {
    return (
        <div className="task-card">
            {/* <h3 className="task-title">{task.title}</h3>
            <p className="task-description">{task.description}</p>
            <p className="task-status">
                Status: <strong>{task.status}</strong>
            </p> */}
        </div>
    );
};

// TaskCard.propTypes = {
//     task: PropTypes.shape({
//         title: PropTypes.string.isRequired,
//         description: PropTypes.string.isRequired,
//         status: PropTypes.string.isRequired,
//     }).isRequired,
// };

export default TaskCard;