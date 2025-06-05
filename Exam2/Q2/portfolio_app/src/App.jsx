import { useState } from 'react';
import Form from './components/Form';
import Display from './components/Display';
import './App.css';

function App() {
  const [entries, setEntries] = useState([]);

  const addEntry = (newEntry) => {
    setEntries([...entries, newEntry]);
  };

  const deleteEntry = (index) => {
    const updated = entries.filter((_, i) => i !== index);
    setEntries(updated);
  };

  return (
    <div className="app">
      <h1>Job Portfolio Form</h1>
      <Form onSubmit={addEntry} />
      <Display data={entries} onDelete={deleteEntry} />
    </div>
  );
}

export default App;
