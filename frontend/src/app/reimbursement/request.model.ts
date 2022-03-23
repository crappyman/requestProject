import { NgIf } from "@angular/common";

export interface Request {
    reqId: number,
    userId: number,
    reqType: string,
    reqAmount: number,
    reqStatus: String,
    submitDate: string,
    approveDate: string,
    manager: string
}