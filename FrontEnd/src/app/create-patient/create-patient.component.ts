import { UserService } from '../services/user.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create',
  templateUrl: './create-patient.component.html',
  styleUrls: ['./create-patient.component.scss']
})

export class CreatePatientComponent implements OnInit {
  response: any;
  createForm!: FormGroup;

  ngOnInit(): void {
    this.createForm = this.fb.group({
      username: [''],
      firstname: [''],
      lastname: [''],
      address: [''],
      city: [''],
      birthdate: [''],
      typediabetes: [''],
      isactive: ['']
    });


  }

  constructor(
    private service: UserService,
    private fb: FormBuilder,
    private http: HttpClient
  ) { }


  createUser() {
    const data = {
      username: this.username?.value,
      firstname: this.firstname?.value,
      lastname: this.lastname?.value,
      address: this.address?.value,
      city: this.city?.value,
      birthdate: this.birthdate?.value,
      diabetestype: this.diabetestype?.value
    };

    console.log(data.diabetestype)
    this.service.post(data).subscribe({
      next: res => {
        this.response = res;
        this.createForm.reset();
      },
      error: err => console.error(err)
    });
  }



  resetForm() {
    this.createForm.reset();
    this.createForm.markAsPristine();
    this.createForm.markAsUntouched();
  }

  setDefaultValues(){
    this.createForm.value.diabetestype="0";
    this.createForm.value.isactive=true;

  }

  get username() {
    return this.createForm.get('username');
  }

  get firstname() {
    return this.createForm.get('firstname');
  }

  get lastname() {
    return this.createForm.get('lastname');
  }

  get address() {
    return this.createForm.get('address');
  }

  get city() {
    return this.createForm.get('city');
  }

  get birthdate() {
    return this.createForm.get('birthdate');
  }

  get diabetestype() {
    return this.createForm.get('diabetestype');
  }
}
