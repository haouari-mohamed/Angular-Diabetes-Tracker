import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Glycemie } from './glycemie';
import { GlycemieService } from './glycemie.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public glycemies: Glycemie[] = [];
  public editGlycemie: Glycemie | null = null;
  public deleteGlycemie: Glycemie | null = null;
  public isAddModalOpen = false;
  public isEditModalOpen = false;
  public isDeleteModalOpen = false;

  title = 'diabetestracker';

 
  constructor(private glycemieService: GlycemieService) { }

  ngOnInit() {
    this.getGlycemies();
  }

  public getGlycemies(): void {
    this.glycemieService.getGlycemies().subscribe(
      (response: Glycemie[]) => {
        this.glycemies = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddGlycemie(addForm: NgForm): void {
    this.glycemieService.addGlycemie(addForm.value).subscribe(
      (response: Glycemie) => {
        this.getGlycemies();
        addForm.reset();
        this.isAddModalOpen = false;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateGlycemie(editForm: NgForm): void {
    this.glycemieService.updateGlycemie(editForm.value).subscribe(
      (response: Glycemie) => {
        this.getGlycemies();
        this.isEditModalOpen = false;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteGlycemie(glycemieId: number): void {
    this.glycemieService.deleteGlycemie(glycemieId).subscribe(
      () => {
        this.getGlycemies();
        this.isDeleteModalOpen = false;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchGlycemies(key: string): void {
    if (!key.trim()) {
      this.getGlycemies();
      return;
    }
    this.glycemieService.searchGlycemies(key).subscribe(
      (response: Glycemie[]) => {
        this.glycemies = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onOpenModal(glycemie: Glycemie | null, mode: string): void {
    if (mode === 'add') {
      this.isAddModalOpen = true;
    }
    if (mode === 'edit') {
      this.editGlycemie = glycemie;
      this.isEditModalOpen = true;
    }
    if (mode === 'delete') {
      this.deleteGlycemie = glycemie;
      this.isDeleteModalOpen = true;
    }
  }

  public closeModal(mode: string): void {
    if (mode === 'add') this.isAddModalOpen = false;
    if (mode === 'edit') this.isEditModalOpen = false;
    if (mode === 'delete') this.isDeleteModalOpen = false;
  }
}