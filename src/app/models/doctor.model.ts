export class DoctorDto {
    constructor(
        public id?: number,
        public nombre?: string,
        public especialidad?: string,
        public clinica_id?: number,
        public email?: string,
        public telefono?: string,
        public fecha_contratacion?: string
    ) {}
}
