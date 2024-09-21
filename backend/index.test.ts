import { describe, it, expect } from "bun:test";
import app from "../backend/index";
import request from "supertest";

describe("GET /", () => {
    it("should return Hello World", async () => {
        const response = await request(app).get("/");
        expect(response.status).toBe(200);
        expect(response.body).toEqual({ message: "Hello World!" });
    });

    it("should return 404 for a non-existent route", async () => {
        const response = await request(app).get("/non-existent-route");
        expect(response.status).toBe(404);
    });
});