from fastapi import FastAPI
from app import api

app = FastAPI()

app.include_router(api.router, prefix="/api")

@app.get("/")
def read_root():
    return {"Hello": "World"}

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="127.0.0.1", port=3000)