import React, { useState } from "react";
import Header from "../../systems/Header";

const SubjectCheck = () => {
    const [file, setFile] = useState();

    const fileReader = new FileReader();

    const handleOnChange = (e) =>{
        setFile(e.target.files[0]);
    };

    const handleOnSubmit = (e) => {
        e.preventDefault();

        if(file){
            fileReader.onload=function(event){
                const csvOutput=event.target.result;
            };
            fileReader.readasText(file);
        }
    };

    return(
        <div className="information">
        <Header />
            <form>
                <input
                    type={"file"}
                    id={"csvfileinput"}
                    accept={".csv"}
                    onChange={handleOnChange}
                />

                <button onClick={(e)=>{handleOnSubmit(e);}}>Import CSV</button>
            </form>
        </div>
    );
}

export default SubjectCheck;