import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  
  
  public user:User = {
    user_email: "",
    user_first_name: "",
    user_last_name: "",
    user_password: "",
    user_username: "",
    user_role_id_fk: 0
  }

  constructor(private us:UserService) { }

  //
  createUser(){

    this.us.createUser(this.user).subscribe(data => {
      console.log(data);
    },
    () => // error handling
    console.log("Try again.")
    )
    
  }

  ngOnInit(): void {
  }

}
