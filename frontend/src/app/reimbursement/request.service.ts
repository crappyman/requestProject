import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Request } from './request.model';

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  
  constructor(private http: HttpClient) { }

  viewAllRequest(): Observable<Request[]> {
    return this.http.get<Request[]>("http://localhost:4444/api/request/allRequests");
  }

  addRequest(requestModel: Request): Observable<Request> {
    return this.http.post<Request>("http://localhost:4444/api/request/addRequest/",requestModel);
  }

  fetchARequest(reqId: any): Observable<Request> {
    return this.http.get<any>("http://localhost:4444/api/request/fetchRequests/"+reqId);
  }
  
  acceptRequest(reqId: any) {
    return this.http.put<any>("http://localhost:4444/api/request/modifyRequestStatus/"+ reqId + "/" + 2, null);
  }

  denieRequest(reqId: any) {
    return this.http.put<any>("http://localhost:4444/api/request/modifyRequestStatus/"+ reqId + "/" + 3, null);
  }
  // viewPendingRequest(reqId: any): Request {


  // }

  reviewRequest(requestModel: Request): Observable<Request> {
    return this.http.put<Request>("http://localhost:4040/api/requests", JSON.stringify(requestModel));
    // return this.http.put<Request>("http://localhost:4040/api/requests"+reqId+"/"+status);
    //return this.http.put<Request>("http://localhost:4040/api/requests/",JSON.stringify([reqId, reqStatus]));
    // return this.http.put<any>(`http://localhost:4040/api/requests/${reqId}/${reqStatus}`,JSON.stringify(Request));
  }

  // deleteRequest(reqId: number): Request[] {
  
  // }
}
