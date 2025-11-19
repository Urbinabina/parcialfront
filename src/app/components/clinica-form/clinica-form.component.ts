import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClinicaDto } from '../../models/clinica.model';
import { ClinicaService } from '../../services/clinica.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clinica-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './clinica-form.component.html',
  styleUrls: ['./clinica-form.component.css']
})
export class ClinicaFormComponent {

  clinica: ClinicaDto = new ClinicaDto();

  constructor(
    private clinicaService: ClinicaService,
    private router: Router
  ) {}

  crearClinica() {
    this.clinicaService.create(this.clinica).subscribe({
      next: () => {
        alert('Clínica creada correctamente');
        this.router.navigate(['/clinicas']);
      },
      error: (err) => console.error(err)
    });
  }

  cancelar() {
    this.router.navigate(['/clinicas']);
  }
}
