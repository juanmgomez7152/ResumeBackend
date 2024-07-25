from app.api.openai.open_ai_conn import openai_call
import logging

logger = logging.getLogger(__name__)
class OpenAiSession:
    def __init__(self, system_message="You are a helpful assistant"):
        self.history = [{"role": "system", "content": system_message}]
        
    async def send_message(self, message):
        
        self.history.append({"role": "user", "content": message})
        print("History: ", self.history)
        answer = await openai_call(self.history)
        
        return answer
