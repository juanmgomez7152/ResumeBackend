from fastapi import APIRouter, HTTPException, Request, Response
import asyncio
import logging
from app.api.openai.openai_session import OpenAiSession

router = APIRouter(tags=["Translation"])

logger = logging.getLogger(__name__)

openai_session = OpenAiSession()

@router.get("/hello")
async def hello():
    return {"message": "Hello, World!"}
