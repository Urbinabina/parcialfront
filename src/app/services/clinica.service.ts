import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClinicaDto } from '../models/clinica.model';

@Injectable({
  providedIn: 'root'
})
export class ClinicaService {

  private baseUrl = 'http://localhost:8080/api/clinicas';

  constructor(private http: HttpClient) {}

  
  list(): Observable<ClinicaDto[]> {
    return this.http.get<ClinicaDto[]>(`${this.baseUrl}/list`);
  }
 
  get(id: number): Observable<ClinicaDto> {
    return this.http.get<ClinicaDto>(`${this.baseUrl}/get/${id}`);
  }
  
  create(dto: ClinicaDto): Observable<ClinicaDto> {
    return this.http.post<ClinicaDto>(`${this.baseUrl}/create`, dto);
  }

  update(id: number, dto: ClinicaDto): Observable<ClinicaDto> {
    return this.http.put<ClinicaDto>(`${this.baseUrl}/update/${id}`, dto);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/delete/${id}`);
  }
}
