function Display({ data, onDelete }) {
  return (
    <div className="display">
      <h2>Submitted Entries</h2>
      {data.length === 0 ? (
        <p>No entries yet</p>
      ) : (
        data.map((item, index) => (
          <div key={index} className="entry">
            <p><strong>Name:</strong> {item.firstName} {item.lastName}</p>
            <p><strong>Email:</strong> {item.email}</p>
            <p><strong>Mobile:</strong> {item.mobile}</p>
            <p><strong>Post:</strong> {item.post}</p>
            <button onClick={() => onDelete(index)}>Delete</button>
          </div>
        ))
      )}
    </div>
  );
}

export default Display;
// my-portfolio-app/src/components/Display.jsx