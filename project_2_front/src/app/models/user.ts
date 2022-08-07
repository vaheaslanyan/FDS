export class User {
    
    // models are meant to replicate the table
    // the constructor will collect data from Java
    constructor(
        public user_email: string,
        public user_first_name: string,
        public user_last_name:string,
        public user_password: string,
        public user_username: string,
        public user_role_id_fk: number
    ) {}
}
