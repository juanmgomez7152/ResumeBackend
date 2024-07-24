from app.api.openai.open_ai_conn import openai_call
import logging

logger = logging.getLogger(__name__)

class OpenAiSession:
    def __init__(self):
        self.history = []
        
    async def send_message(self, message):
        logger.info(f"Sending message: {message}")
        self.history.append(message)
        answer = await openai_call(self.history)
        self.history.append(answer)
        
        return answer
