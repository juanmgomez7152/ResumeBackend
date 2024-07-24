import openai
import os
import tiktoken
import asyncio
from dotenv import load_dotenv

client = openai.OpenAI()
model_name = "gpt-3.5-turbo"
system_message = "You are a helpful assistant"
openai.api_key = os.getenv("OPENAI_API_KEY")

async def openai_call(prompt):
    completion = client.Completion.create(
      engine=model_name,
      prompt=prompt
    )
    response = completion.choices[0].text
    return response