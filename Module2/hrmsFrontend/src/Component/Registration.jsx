
import React from 'react';

function Registration() {
    const [empId, setEmpId] = React.useState("");
    const [empName, setEmpName] = React.useState("");
    const [empDesignation, setEmpDesignation] = React.useState("");
    const [empStack, setEmpStack] = React.useState("");
    const [empEmail, setEmpEmail] = React.useState("");
    const [empPassword, setEmpPassword] = React.useState("");

    async function sendData(e) {
        e.preventDefault();

        try {
            const server = await fetch("http://localhost:8080/v1/user/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    emp_id: Number(empId),
                    emp_name: empName,
                    designation: empDesignation,
                    stack: empStack,
                    email: empEmail,
                    password: empPassword
                })
            });

            const status = await server.text();

            if (server.ok) {
                alert("Registration successful!");
                console.log(status);
            } else {
                alert("Registration failed: " + status);
                console.error(status);
            }
        } catch (error) {
            console.error("Error connecting to backend:", error);
            alert("Unable to connect to Spring Boot. Check the backend server.");
        }
    }

    return (
        <div>
            <form onSubmit={sendData}>

                <div className="form-group">
                    <label htmlFor="empName">Name</label>
                    <input
                        id="empName"
                        onChange={(e) => setEmpName(e.target.value)}
                        type="text"
                        className="form-control"
                        placeholder="Enter name"
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="empId">Emp_ID</label>
                    <input
                        id="empId"
                        onChange={(e) => setEmpId(e.target.value)}
                        type="number"
                        className="form-control"
                        placeholder="Enter Employee Id"
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="empDesignation">Designation</label>
                    <input
                        id="empDesignation"
                        onChange={(e) => setEmpDesignation(e.target.value)}
                        type="text"
                        className="form-control"
                        placeholder="Enter Designation"
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="empStack">Stack</label>
                    <input
                        id="empStack"
                        onChange={(e) => setEmpStack(e.target.value)}
                        type="text"
                        className="form-control"
                        placeholder="Enter Stack"
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="empEmail">Email address</label>
                    <input
                        id="empEmail"
                        onChange={(e) => setEmpEmail(e.target.value)}
                        type="email"
                        className="form-control"
                        placeholder="Enter email"
                        required
                    />
                </div>

                <div className="form-group">
                    <label htmlFor="empPassword">Password</label>
                    <input
                        id="empPassword"
                        onChange={(e) => setEmpPassword(e.target.value)}
                        type="password"
                        className="form-control"
                        placeholder="Enter password"
                        required
                    />
                </div>

                <button type="submit" className="btn btn-primary">
                    Submit
                </button>

            </form>
        </div>
    );
}

export default Registration;
