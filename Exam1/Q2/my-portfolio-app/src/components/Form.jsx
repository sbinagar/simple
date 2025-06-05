import { useState } from 'react';

function Form({ onSubmit }) {
  const [form, setForm] = useState({
    firstName: '',
    lastName: '',
    email: '',
    mobile: '',
    post: ''
  });
  const [errors, setErrors] = useState({});

  const validate = () => {
    const err = {};
    if (!form.firstName.trim()) err.firstName = "First name is required";
    else if (form.firstName.length > 20) err.firstName = "Max 20 chars";

    if (!form.lastName.trim()) err.lastName = "Last name is required";
    else if (form.lastName.length > 20) err.lastName = "Max 20 chars";

    if (!form.email.includes("@") || !form.email.includes(".") || !/\d/.test(form.email)) {
        err.email = "Email must include @, a dot (.), and a number";
        }



    if (form.mobile.length > 12) err.mobile = "Max 12 digits";

    if (!form.post.trim()) err.post = "Post is required";

    return err;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const err = validate();
    if (Object.keys(err).length === 0) {
      onSubmit(form);
      setForm({ firstName: '', lastName: '', email: '', mobile: '', post: '' });
      setErrors({});
    } else {
      setErrors(err);
    }
  };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  return (
    <form onSubmit={handleSubmit} className="form">
      <input name="firstName" placeholder="First Name" value={form.firstName} onChange={handleChange} />
      {errors.firstName && <p className="error">{errors.firstName}</p>}

      <input name="lastName" placeholder="Last Name" value={form.lastName} onChange={handleChange} />
      {errors.lastName && <p className="error">{errors.lastName}</p>}

      <input name="email" placeholder="Email" value={form.email} onChange={handleChange} />
      {errors.email && <p className="error">{errors.email}</p>}

      <input name="mobile" placeholder="Mobile No" value={form.mobile} onChange={handleChange} />
      {errors.mobile && <p className="error">{errors.mobile}</p>}

      <input name="post" placeholder="Post Applied For" value={form.post} onChange={handleChange} />
      {errors.post && <p className="error">{errors.post}</p>}

      <button type="submit">Add</button>
    </form>
  );
}

export default Form;
