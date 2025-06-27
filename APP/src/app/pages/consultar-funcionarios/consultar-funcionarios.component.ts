import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FuncionarioService } from '../../services/funcionario.service';
import { Funcionario } from '../../models/funcionario';
import { Router } from '@angular/router';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-consultar-funcionarios',
  standalone: true,
  imports: [CommonModule, MatTableModule],
  templateUrl: './consultar-funcionarios.component.html',
  styleUrl: './consultar-funcionarios.component.css'
})

export class ConsultarFuncionariosComponent {
  displayedColumns: string[] = ['nome', 'cpf', 'cidade', 'estado'];

  funcionarios: Funcionario[] = [];

  constructor(private funcionarioService: FuncionarioService, private router: Router) { }

  ngOnInit(): void {
    this.carregarFuncionarios();
  }

  editarFuncionario(funcionario: Funcionario): void {
    this.router.navigate(['/cadastrar', funcionario.id]);
  }

  excluirFuncionario(id: number): void {
    if (confirm('Tem certeza que deseja excluir este funcionário?')) {
      this.funcionarioService.excluir(id).subscribe(() => {
        alert('Funcionário excluído com sucesso!');
        this.carregarFuncionarios();
      });
    }
  }

  carregarFuncionarios(): void {
    this.funcionarioService.listar().subscribe(funcionarios => {
      this.funcionarios = funcionarios;
    });
  }

}
