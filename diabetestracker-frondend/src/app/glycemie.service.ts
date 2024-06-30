import { Injectable } from "@angular/core";
import { Glycemie } from "./glycemie";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from "../environments/environments";

@Injectable({ providedIn: 'root' })
export class GlycemieService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getGlycemies(): Observable<Glycemie[]> {
    return this.http.get<Glycemie[]>(`${this.apiServerUrl}/glycemie/all`);
  }

  public addGlycemie(glycemie: Glycemie): Observable<Glycemie> {
    return this.http.post<Glycemie>(`${this.apiServerUrl}/glycemie/add`, glycemie);
  }

  public updateGlycemie(glycemie: Glycemie): Observable<Glycemie> {
    return this.http.put<Glycemie>(`${this.apiServerUrl}/glycemie/update`, glycemie);
  }

  public deleteGlycemie(glycemieId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/glycemie/delete/${glycemieId}`);
  }

  public searchGlycemies(name: string): Observable<Glycemie[]> {
    return this.http.get<Glycemie[]>(`${this.apiServerUrl}/glycemie/search/${name}`);
  }
}