import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClinicaService } from '../../services/clinica.service';
import { ClinicaDto } from '../../models/clinica.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clinica-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './clinica-list.component.html',
  styleUrls: ['./clinica-list.component.css']
})
export class ClinicaListComponent implements OnInit {

  clinicas: ClinicaDto[] = [];

  constructor(
    private clinicaService: ClinicaService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarClinicas();
  }

  cargarClinicas() {
    this.clinicaService.list().subscribe({
      next: (data) => (this.clinicas = data),
      error: (err) => console.error(err)
    });
  }

  editar(id?: number) {
    if (!id) return;
    this.router.navigate(['/clinicas/editar', id]);
  }

  eliminar(id?: number) {
    if (!id) return;

    if (confirm('¿Deseas eliminar esta clínica?')) {
      this.clinicaService.delete(id).subscribe({
        next: () => this.cargarClinicas(),
        error: (err) => console.error(err)
      });
    }
  }
}
