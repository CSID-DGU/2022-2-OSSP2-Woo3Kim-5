import React, { useState } from "react";
import Header from "../../systems/Header";
import logo from '../../assets/images/subjectguide.png';
import './index.css';

const SubjectCheck = () => {
  const [file, setFile] = useState();

  const fileReader = new FileReader();

  const handleOnChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleOnSubmit = (e) => {
    e.preventDefault();

    if (file) {
      fileReader.onload = function (event) {
        const xlsxOutput = event.target.result;
      };
      fileReader.readasText(file);
    }
  };

  return (
    <div className="information">
      <Header />
      <div className="content">
        <div className="guide">
          <img src={logo} alt="엑셀가이드"></img>
        </div>
        <div>
          <form>
            <br/><br/>
            <input
              type={"file"}
              id={"xlsxfileinput"}
              accept={".xlsx"}
              onChange={handleOnChange}
            />

            <button className="submit-btn" onClick={(e) => { handleOnSubmit(e); }}>입력</button>
          </form>
        </div>

      </div>
    </div>
  );
}

export default SubjectCheck;