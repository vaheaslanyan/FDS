export class User {
    
    // models are meant to replicate the table
    // the constructor will collect data from Java
    userEmail?: string;
    userFirstName?: string;
    userLastName?:string;
    userPassword?: string;
    userUsername?: string;
    userRoleIdFk?: number;
}
